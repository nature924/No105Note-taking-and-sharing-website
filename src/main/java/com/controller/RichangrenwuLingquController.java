
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
 * 领取任务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/richangrenwuLingqu")
public class RichangrenwuLingquController {
    private static final Logger logger = LoggerFactory.getLogger(RichangrenwuLingquController.class);

    private static final String TABLE_NAME = "richangrenwuLingqu";

    @Autowired
    private RichangrenwuLingquService richangrenwuLingquService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private BijiService bijiService;//笔记广场
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
        PageUtils page = richangrenwuLingquService.queryPage(params);

        //字典表数据转换
        List<RichangrenwuLingquView> list =(List<RichangrenwuLingquView>)page.getList();
        for(RichangrenwuLingquView c:list){
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
        RichangrenwuLingquEntity richangrenwuLingqu = richangrenwuLingquService.selectById(id);
        if(richangrenwuLingqu !=null){
            //entity转view
            RichangrenwuLingquView view = new RichangrenwuLingquView();
            BeanUtils.copyProperties( richangrenwuLingqu , view );//把实体数据重构到view中
            //级联表 日常任务
            //级联表
            RichangrenwuEntity richangrenwu = richangrenwuService.selectById(richangrenwuLingqu.getRichangrenwuId());
            if(richangrenwu != null){
            BeanUtils.copyProperties( richangrenwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setRichangrenwuId(richangrenwu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(richangrenwuLingqu.getYonghuId());
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
    public R save(@RequestBody RichangrenwuLingquEntity richangrenwuLingqu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,richangrenwuLingqu:{}",this.getClass().getName(),richangrenwuLingqu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            richangrenwuLingqu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<RichangrenwuLingquEntity> queryWrapper = new EntityWrapper<RichangrenwuLingquEntity>()
            .eq("richangrenwu_id", richangrenwuLingqu.getRichangrenwuId())
            .eq("yonghu_id", richangrenwuLingqu.getYonghuId())
            .eq("richangrenwu_lingqu_time", new SimpleDateFormat("yyyy-MM-dd").format(richangrenwuLingqu.getRichangrenwuLingquTime()))
            .in("richangrenwu_lingqu_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RichangrenwuLingquEntity richangrenwuLingquEntity = richangrenwuLingquService.selectOne(queryWrapper);
        if(richangrenwuLingquEntity==null){
            richangrenwuLingqu.setInsertTime(new Date());
            richangrenwuLingqu.setRichangrenwuLingquYesnoTypes(1);
            richangrenwuLingqu.setCreateTime(new Date());
            richangrenwuLingquService.insert(richangrenwuLingqu);
            return R.ok();
        }else {
            if(richangrenwuLingquEntity.getRichangrenwuLingquYesnoTypes()==1)
                return R.error(511,"该天已有该任务的接取,不能重复接取");
            else if(richangrenwuLingquEntity.getRichangrenwuLingquYesnoTypes()==2)
                return R.error(511,"该天已完成该任务的接取,不能重复接取");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RichangrenwuLingquEntity richangrenwuLingqu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,richangrenwuLingqu:{}",this.getClass().getName(),richangrenwuLingqu.toString());
        RichangrenwuLingquEntity oldRichangrenwuLingquEntity = richangrenwuLingquService.selectById(richangrenwuLingqu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            richangrenwuLingqu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(richangrenwuLingqu.getRichangrenwuLingquYesnoText()) || "null".equals(richangrenwuLingqu.getRichangrenwuLingquYesnoText())){
                richangrenwuLingqu.setRichangrenwuLingquYesnoText(null);
        }

            richangrenwuLingquService.updateById(richangrenwuLingqu);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody RichangrenwuLingquEntity richangrenwuLingquEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,richangrenwuLingquEntity:{}",this.getClass().getName(),richangrenwuLingquEntity.toString());

        RichangrenwuLingquEntity oldRichangrenwuLingqu = richangrenwuLingquService.selectById(richangrenwuLingquEntity.getId());//查询原先数据

        if(richangrenwuLingquEntity.getRichangrenwuLingquYesnoTypes() == 2){//通过
            RichangrenwuEntity  richangrenwuEntity= richangrenwuService.selectById(oldRichangrenwuLingqu.getRichangrenwuId());
            if(richangrenwuEntity == null)
                return R.error("查不到任务");
            YonghuEntity yonghuEntity = yonghuService.selectById(oldRichangrenwuLingqu.getYonghuId());
            if(yonghuEntity == null)
                return R.error("查不到用户");
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney()+richangrenwuEntity.getRichangrenwuJifen());

            yonghuService.updateById(yonghuEntity);

            richangrenwuLingquEntity.setRichangrenwuLingquTypes(2);
        }else if(richangrenwuLingquEntity.getRichangrenwuLingquYesnoTypes() == 3){//拒绝
            richangrenwuLingquEntity.setRichangrenwuLingquTypes(3);
        }
        richangrenwuLingquEntity.setRichangrenwuLingquShenheTime(new Date());//审核时间
        richangrenwuLingquService.updateById(richangrenwuLingquEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<RichangrenwuLingquEntity> oldRichangrenwuLingquList =richangrenwuLingquService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        richangrenwuLingquService.deleteBatchIds(Arrays.asList(ids));

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
            List<RichangrenwuLingquEntity> richangrenwuLingquList = new ArrayList<>();//上传的东西
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
                            RichangrenwuLingquEntity richangrenwuLingquEntity = new RichangrenwuLingquEntity();
//                            richangrenwuLingquEntity.setRichangrenwuId(Integer.valueOf(data.get(0)));   //日常任务 要改的
//                            richangrenwuLingquEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            richangrenwuLingquEntity.setRichangrenwuLingquUuidNumber(data.get(0));                    //领取任务编号 要改的
//                            richangrenwuLingquEntity.setRichangrenwuLingquTime(sdf.parse(data.get(0)));          //所属日期 要改的
//                            richangrenwuLingquEntity.setInsertTime(date);//时间
//                            richangrenwuLingquEntity.setRichangrenwuLingquTypes(Integer.valueOf(data.get(0)));   //任务状态 要改的
//                            richangrenwuLingquEntity.setRichangrenwuLingquYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            richangrenwuLingquEntity.setRichangrenwuLingquYesnoText(data.get(0));                    //审核回复 要改的
//                            richangrenwuLingquEntity.setRichangrenwuLingquShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            richangrenwuLingquEntity.setCreateTime(date);//时间
                            richangrenwuLingquList.add(richangrenwuLingquEntity);


                            //把要查询是否重复的字段放入map中
                                //领取任务编号
                                if(seachFields.containsKey("richangrenwuLingquUuidNumber")){
                                    List<String> richangrenwuLingquUuidNumber = seachFields.get("richangrenwuLingquUuidNumber");
                                    richangrenwuLingquUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> richangrenwuLingquUuidNumber = new ArrayList<>();
                                    richangrenwuLingquUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("richangrenwuLingquUuidNumber",richangrenwuLingquUuidNumber);
                                }
                        }

                        //查询是否重复
                         //领取任务编号
                        List<RichangrenwuLingquEntity> richangrenwuLingquEntities_richangrenwuLingquUuidNumber = richangrenwuLingquService.selectList(new EntityWrapper<RichangrenwuLingquEntity>().in("richangrenwu_lingqu_uuid_number", seachFields.get("richangrenwuLingquUuidNumber")));
                        if(richangrenwuLingquEntities_richangrenwuLingquUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RichangrenwuLingquEntity s:richangrenwuLingquEntities_richangrenwuLingquUuidNumber){
                                repeatFields.add(s.getRichangrenwuLingquUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [领取任务编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        richangrenwuLingquService.insertBatch(richangrenwuLingquList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = richangrenwuLingquService.queryPage(params);

        //字典表数据转换
        List<RichangrenwuLingquView> list =(List<RichangrenwuLingquView>)page.getList();
        for(RichangrenwuLingquView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RichangrenwuLingquEntity richangrenwuLingqu = richangrenwuLingquService.selectById(id);
            if(richangrenwuLingqu !=null){


                //entity转view
                RichangrenwuLingquView view = new RichangrenwuLingquView();
                BeanUtils.copyProperties( richangrenwuLingqu , view );//把实体数据重构到view中

                //级联表
                    RichangrenwuEntity richangrenwu = richangrenwuService.selectById(richangrenwuLingqu.getRichangrenwuId());
                if(richangrenwu != null){
                    BeanUtils.copyProperties( richangrenwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setRichangrenwuId(richangrenwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(richangrenwuLingqu.getYonghuId());
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
    public R add(@RequestBody RichangrenwuLingquEntity richangrenwuLingqu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,richangrenwuLingqu:{}",this.getClass().getName(),richangrenwuLingqu.toString());
        Wrapper<RichangrenwuLingquEntity> queryWrapper = new EntityWrapper<RichangrenwuLingquEntity>()
            .eq("richangrenwu_id", richangrenwuLingqu.getRichangrenwuId())
            .eq("yonghu_id", richangrenwuLingqu.getYonghuId())
            .eq("richangrenwu_lingqu_uuid_number", richangrenwuLingqu.getRichangrenwuLingquUuidNumber())
            .eq("richangrenwu_lingqu_types", richangrenwuLingqu.getRichangrenwuLingquTypes())
            .in("richangrenwu_lingqu_yesno_types", new Integer[]{1,2})
            .eq("richangrenwu_lingqu_yesno_text", richangrenwuLingqu.getRichangrenwuLingquYesnoText())
//            .notIn("richangrenwu_lingqu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RichangrenwuLingquEntity richangrenwuLingquEntity = richangrenwuLingquService.selectOne(queryWrapper);
        if(richangrenwuLingquEntity==null){
            richangrenwuLingqu.setInsertTime(new Date());
            richangrenwuLingqu.setRichangrenwuLingquYesnoTypes(1);
            richangrenwuLingqu.setCreateTime(new Date());
        richangrenwuLingquService.insert(richangrenwuLingqu);

            return R.ok();
        }else {
            if(richangrenwuLingquEntity.getRichangrenwuLingquYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(richangrenwuLingquEntity.getRichangrenwuLingquYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

