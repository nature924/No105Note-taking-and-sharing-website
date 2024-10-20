
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 笔记广场
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/biji")
public class BijiController {
    private static final Logger logger = LoggerFactory.getLogger(BijiController.class);

    private static final String TABLE_NAME = "biji";

    @Autowired
    private BijiService bijiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private BijiCollectionService bijiCollectionService;//笔记收藏
    @Autowired
    private BijiLiuyanService bijiLiuyanService;//笔记留言
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private GuanzhuService guanzhuService;//我的关注
    @Autowired
    private RichangrenwuService richangrenwuService;//日常任务
    @Autowired
    private RichangrenwuLingquService richangrenwuLingquService;//领取任务
    @Autowired
    private ShangpinService shangpinService;//商品
    @Autowired
    private ShangpinCollectionService shangpinCollectionService;//商品收藏
    @Autowired
    private ShangpinCommentbackService shangpinCommentbackService;//商品评价
    @Autowired
    private ShangpinOrderService shangpinOrderService;//商品兑换
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = bijiService.queryPage(params);

        //字典表数据转换
        List<BijiView> list =(List<BijiView>)page.getList();
        for(BijiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BijiEntity biji = bijiService.selectById(id);
        if(biji !=null){
            //entity转view
            BijiView view = new BijiView();
            BeanUtils.copyProperties( biji , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(biji.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BijiEntity biji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,biji:{}",this.getClass().getName(),biji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            biji.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BijiEntity> queryWrapper = new EntityWrapper<BijiEntity>()
            .eq("yonghu_id", biji.getYonghuId())
            .eq("biji_name", biji.getBijiName())
            .eq("zan_number", biji.getZanNumber())
            .eq("cai_number", biji.getCaiNumber())
            .eq("biji_types", biji.getBijiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BijiEntity bijiEntity = bijiService.selectOne(queryWrapper);
        if(bijiEntity==null){
            biji.setZanNumber(1);
            biji.setCaiNumber(1);
            biji.setInsertTime(new Date());
            biji.setCreateTime(new Date());
            bijiService.insert(biji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BijiEntity biji, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,biji:{}",this.getClass().getName(),biji.toString());
        BijiEntity oldBijiEntity = bijiService.selectById(biji.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            biji.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(biji.getBijiPhoto()) || "null".equals(biji.getBijiPhoto())){
                biji.setBijiPhoto(null);
        }
        if("".equals(biji.getBijiContent()) || "null".equals(biji.getBijiContent())){
                biji.setBijiContent(null);
        }

            bijiService.updateById(biji);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BijiEntity> oldBijiList =bijiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        bijiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<BijiEntity> bijiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BijiEntity bijiEntity = new BijiEntity();
//                            bijiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            bijiEntity.setBijiName(data.get(0));                    //笔记名称 要改的
//                            bijiEntity.setBijiUuidNumber(data.get(0));                    //笔记编号 要改的
//                            bijiEntity.setBijiPhoto("");//详情和图片
//                            bijiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            bijiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            bijiEntity.setBijiTypes(Integer.valueOf(data.get(0)));   //笔记类型 要改的
//                            bijiEntity.setBijiContent("");//详情和图片
//                            bijiEntity.setInsertTime(date);//时间
//                            bijiEntity.setCreateTime(date);//时间
                            bijiList.add(bijiEntity);


                            //把要查询是否重复的字段放入map中
                                //笔记编号
                                if(seachFields.containsKey("bijiUuidNumber")){
                                    List<String> bijiUuidNumber = seachFields.get("bijiUuidNumber");
                                    bijiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> bijiUuidNumber = new ArrayList<>();
                                    bijiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("bijiUuidNumber",bijiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //笔记编号
                        List<BijiEntity> bijiEntities_bijiUuidNumber = bijiService.selectList(new EntityWrapper<BijiEntity>().in("biji_uuid_number", seachFields.get("bijiUuidNumber")));
                        if(bijiEntities_bijiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BijiEntity s:bijiEntities_bijiUuidNumber){
                                repeatFields.add(s.getBijiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [笔记编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bijiService.insertBatch(bijiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<BijiView> returnBijiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("bijiYesnoTypes",2);
        PageUtils pageUtils = bijiCollectionService.queryPage(params1);
        List<BijiCollectionView> collectionViewsList =(List<BijiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(BijiCollectionView collectionView:collectionViewsList){
            Integer bijiTypes = collectionView.getBijiTypes();
            if(typeMap.containsKey(bijiTypes)){
                typeMap.put(bijiTypes,typeMap.get(bijiTypes)+1);
            }else{
                typeMap.put(bijiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("bijiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("bijiYesnoTypes",2);
            PageUtils pageUtils1 = bijiService.queryPage(params2);
            List<BijiView> bijiViewList =(List<BijiView>)pageUtils1.getList();
            returnBijiViewList.addAll(bijiViewList);
            if(returnBijiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("bijiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = bijiService.queryPage(params);
        if(returnBijiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnBijiViewList.size();//要添加的数量
            List<BijiView> bijiViewList =(List<BijiView>)page.getList();
            for(BijiView bijiView:bijiViewList){
                Boolean addFlag = true;
                for(BijiView returnBijiView:returnBijiViewList){
                    if(returnBijiView.getId().intValue() ==bijiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnBijiViewList.add(bijiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnBijiViewList = returnBijiViewList.subList(0, limit);
        }

        for(BijiView c:returnBijiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnBijiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = bijiService.queryPage(params);

        //字典表数据转换
        List<BijiView> list =(List<BijiView>)page.getList();
        for(BijiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BijiEntity biji = bijiService.selectById(id);
            if(biji !=null){


                //entity转view
                BijiView view = new BijiView();
                BeanUtils.copyProperties( biji , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(biji.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody BijiEntity biji, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,biji:{}",this.getClass().getName(),biji.toString());
        Wrapper<BijiEntity> queryWrapper = new EntityWrapper<BijiEntity>()
            .eq("yonghu_id", biji.getYonghuId())
            .eq("biji_name", biji.getBijiName())
            .eq("biji_uuid_number", biji.getBijiUuidNumber())
            .eq("zan_number", biji.getZanNumber())
            .eq("cai_number", biji.getCaiNumber())
            .eq("biji_types", biji.getBijiTypes())
//            .notIn("biji_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BijiEntity bijiEntity = bijiService.selectOne(queryWrapper);
        if(bijiEntity==null){
                biji.setZanNumber(1);
                biji.setCaiNumber(1);
            biji.setInsertTime(new Date());
            biji.setCreateTime(new Date());
        bijiService.insert(biji);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

