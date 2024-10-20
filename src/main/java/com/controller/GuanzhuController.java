
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
 * 我的关注
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guanzhu")
public class GuanzhuController {
    private static final Logger logger = LoggerFactory.getLogger(GuanzhuController.class);

    private static final String TABLE_NAME = "guanzhu";

    @Autowired
    private GuanzhuService guanzhuService;


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
        PageUtils page = guanzhuService.queryPage(params);

        //字典表数据转换
        List<GuanzhuView> list =(List<GuanzhuView>)page.getList();
        for(GuanzhuView c:list){
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
        GuanzhuEntity guanzhu = guanzhuService.selectById(id);
        if(guanzhu !=null){
            //entity转view
            GuanzhuView view = new GuanzhuView();
            BeanUtils.copyProperties( guanzhu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(guanzhu.getYonghuId());
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
    public R save(@RequestBody GuanzhuEntity guanzhu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guanzhu:{}",this.getClass().getName(),guanzhu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            guanzhu.setGuanzhuKucunNumber(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<GuanzhuEntity> queryWrapper = new EntityWrapper<GuanzhuEntity>()
            .eq("yonghu_id", guanzhu.getYonghuId())
            .eq("guanzhu_kucun_number", guanzhu.getGuanzhuKucunNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanzhuEntity guanzhuEntity = guanzhuService.selectOne(queryWrapper);
        if(guanzhuEntity==null){
            guanzhu.setInsertTime(new Date());
            guanzhu.setCreateTime(new Date());
            guanzhuService.insert(guanzhu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuanzhuEntity guanzhu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,guanzhu:{}",this.getClass().getName(),guanzhu.toString());
        GuanzhuEntity oldGuanzhuEntity = guanzhuService.selectById(guanzhu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            guanzhu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            guanzhuService.updateById(guanzhu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GuanzhuEntity> oldGuanzhuList =guanzhuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        guanzhuService.deleteBatchIds(Arrays.asList(ids));

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
            List<GuanzhuEntity> guanzhuList = new ArrayList<>();//上传的东西
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
                            GuanzhuEntity guanzhuEntity = new GuanzhuEntity();
//                            guanzhuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            guanzhuEntity.setGuanzhuUuidNumber(data.get(0));                    //关注编号 要改的
//                            guanzhuEntity.setGuanzhuKucunNumber(Integer.valueOf(data.get(0)));   //关注人 要改的
//                            guanzhuEntity.setInsertTime(date);//时间
//                            guanzhuEntity.setCreateTime(date);//时间
                            guanzhuList.add(guanzhuEntity);


                            //把要查询是否重复的字段放入map中
                                //关注编号
                                if(seachFields.containsKey("guanzhuUuidNumber")){
                                    List<String> guanzhuUuidNumber = seachFields.get("guanzhuUuidNumber");
                                    guanzhuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guanzhuUuidNumber = new ArrayList<>();
                                    guanzhuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("guanzhuUuidNumber",guanzhuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //关注编号
                        List<GuanzhuEntity> guanzhuEntities_guanzhuUuidNumber = guanzhuService.selectList(new EntityWrapper<GuanzhuEntity>().in("guanzhu_uuid_number", seachFields.get("guanzhuUuidNumber")));
                        if(guanzhuEntities_guanzhuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuanzhuEntity s:guanzhuEntities_guanzhuUuidNumber){
                                repeatFields.add(s.getGuanzhuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [关注编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guanzhuService.insertBatch(guanzhuList);
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
        PageUtils page = guanzhuService.queryPage(params);

        //字典表数据转换
        List<GuanzhuView> list =(List<GuanzhuView>)page.getList();
        for(GuanzhuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GuanzhuEntity guanzhu = guanzhuService.selectById(id);
            if(guanzhu !=null){


                //entity转view
                GuanzhuView view = new GuanzhuView();
                BeanUtils.copyProperties( guanzhu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(guanzhu.getYonghuId());
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
    public R add(@RequestBody GuanzhuEntity guanzhu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,guanzhu:{}",this.getClass().getName(),guanzhu.toString());
        Wrapper<GuanzhuEntity> queryWrapper = new EntityWrapper<GuanzhuEntity>()
            .eq("yonghu_id", guanzhu.getYonghuId())
            .eq("guanzhu_uuid_number", guanzhu.getGuanzhuUuidNumber())
            .eq("guanzhu_kucun_number", guanzhu.getGuanzhuKucunNumber())
//            .notIn("guanzhu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanzhuEntity guanzhuEntity = guanzhuService.selectOne(queryWrapper);
        if(guanzhuEntity==null){
            guanzhu.setInsertTime(new Date());
            guanzhu.setCreateTime(new Date());
        guanzhuService.insert(guanzhu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

