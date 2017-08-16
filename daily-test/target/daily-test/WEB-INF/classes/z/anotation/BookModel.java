package z.anotation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;

/**
 *
 * Created by ZhongHe.Zh on 2016/12/27.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookModel implements Serializable{

    public String name;

    public String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
