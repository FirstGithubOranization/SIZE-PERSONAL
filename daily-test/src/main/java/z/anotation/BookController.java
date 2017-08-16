package z.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by ZhongHe.Zh on 2016/12/27.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/insert/{token}",method = RequestMethod.GET)
    public ModelAndView insert(HttpServletRequest request) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        BookModel bookModel = new BookModel();
        bookModel.setName(name);
        bookModel.setPrice(price);
//        bookService.insert(bookModel,token);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("asdasd");
        return mv;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView update(HttpRequest request) {
        System.out.println("111111111111111111111111111111");
        return  null;
    }

    @RequestMapping(value = "query")
    public ModelAndView query(HttpRequest request) {
        return null;
    }
}
