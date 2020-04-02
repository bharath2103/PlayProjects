package controllers;

import Implementation.Shop;
import com.fasterxml.jackson.databind.JsonNode;
import model.Item;
import play.libs.Json;
import play.mvc.*;

import java.util.List;

public class ItemController extends Controller {
    Shop shop = new Shop();

    public Result list(){
        List<Item> items = shop.list();
        if(items != null) {
            return ok(Json.toJson(items));
        }
        else
            return notFound();
        //return status(NOT_IMPLEMENTED);
    }

    public Result create(Http.Request request){
        JsonNode json = request.body().asJson();
        Item i = Json.fromJson(json, Item.class);
        Item i1 = shop.create(i.name, i.price);
        if (i1 != null){
            return ok("Item added");
        }
        else return status(NOT_IMPLEMENTED);
    }
    public Result details(Long id){
        Item item = shop.get(id);
        if(item != null){
            return ok(Json.toJson(item));
        }
        else {
            return notFound();
        }
       //return status(NOT_IMPLEMENTED);
    }
    public Result update(Long id){
        return status(NOT_IMPLEMENTED);
    }
    public Result delete(Long id){
        return status(NOT_IMPLEMENTED);
    }
}
