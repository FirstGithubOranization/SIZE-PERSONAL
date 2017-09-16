//package z.关于JDNI与JUNIT整合办法;
//
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * TITLE:
// *
// * @author ZhongHe.Zh
// * @time 2017-09-06 18:25
// **/
//@Transactional
//public class PrizeTest extends BaseTest{
//
////    @Autowired
////    private PrizeServiceBase prizeServiceBase;
////
////
////    @Test
////    public void insertTest(){
////        Prize prize = new Prize();
////        prize.setActivityid(1);
////        prize.setCreaterid(2+"");
////        prize.setName("5个墨子币");
////        prize.setImgurl("xxx.png");
////        prize.setLeftnum(1000);
////        prize.setLeftoptnum(10000);
////        prize.setRate(1);
////        prize.setNum(1000);
////        prize.setPrizedicid(1);
////        prize.setSortnum(1);
////        prizeServiceBase.insertPrize(prize);
////    }
////
////    @Test
////    public void updateTest(){
////        Prize prize = new Prize();
////        prize.setId(1);
////        prize.setActivityid(2);
////        prize.setCreaterid(2+"");
////        prize.setName("5个墨子币");
////        prize.setImgurl("xxx.png");
////        prize.setLeftnum(1000);
////        prize.setLeftoptnum(10000);
////        prize.setRate(1);
////        prize.setNum(1000);
////        prize.setPrizedicid(1);
////        prize.setSortnum(1);
////        prizeServiceBase.updatePrize(prize);
////    }
////
////    @Test
////    public void detailTest(){
////        C2SPrizeBean prize = new C2SPrizeBean();
////        prize.setId(1);
////        prize.setIsfilter(1);
////        Prize bean= prizeServiceBase.detailPrize(prize);
////        Assert.assertEquals(null,bean.getLeftnum());
////        prize.setIsfilter(0);
////        Prize bean1= prizeServiceBase.detailPrize(prize);
////        Assert.assertNotEquals(null,bean1.getLeftnum());
////
////    }
////
////    @Test
////    public void listTest(){
////        C2SPrizeBean prize = new C2SPrizeBean();
////        prize.setIsfilter(1);
////        prize.setActivityid(1);
////        List<Prize> beans= prizeServiceBase.listPrize(prize);
////        Assert.assertEquals(1,beans.size());
////    }
////
////
//
//
//}
//
