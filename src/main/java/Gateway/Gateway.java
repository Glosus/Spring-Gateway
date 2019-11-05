package Gateway;

import lombok.Data;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class Gateway {
    //GetItems
    @RequestMapping(
            value = "/warehouse/items",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    @ResponseBody
    public String GetItems() {
        return "GetItems";
    }

    //GetItemById
    @RequestMapping(
            value = "/warehouse/items/{item_id}",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    @ResponseBody
    public String GetItemById(
            @PathVariable String item_id) {
        return "GetItemById " + item_id;
    }

    //CreateItem
    @RequestMapping(
            value = "/warehouse/items",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    @ResponseBody
    public String CreateItem() {
        return "CreateItem";
    }

    //AddExistingItems
    @RequestMapping(
            value = "/warehouse/items/{id}/addition/{amount}",
            method = RequestMethod.PUT,
            headers = "Accept=application/json")
    @ResponseBody
    public String AddExistingItems(@PathVariable String id, @PathVariable String amount) {
        return "AddExistingItems " + id + " " + amount;
    }

    //GetOrders
    @RequestMapping(
            value = "/orders",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    @ResponseBody
    public String GetOrders() {
        return "GetOrders";
    }

    //GetOrderById
    @RequestMapping(
            value = "/orders/{order_id}",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    @ResponseBody
    public String GetOrderById(
            @PathVariable String item_id) {
        return "GetOrders " + item_id;
    }

    //AddItemToOrder
    @RequestMapping(
            value = "/orders/{order_id}/addition",
            method = RequestMethod.PUT,
            headers = "Accept=application/json")
    @ResponseBody
    public String AddItemToOrder(@PathVariable String order_id) {
        return "AddItemToOrder " + order_id;
    }

    //PerformPayment
    @RequestMapping(
            value = "/orders/{order_id}/pay",
            method = RequestMethod.PUT,
            headers = "Accept=application/json")
    @ResponseBody
    public String PerformPayment(@PathVariable String order_id) {
        return "PerformPayment " + order_id;
    }

    //ChangeOrderStatus
    @RequestMapping(
            value = "/orders/{order_id}/status/{status}",
            method = RequestMethod.PUT,
            headers = "Accept=application/json")
    @ResponseBody
    public String ChangeOrderStatus(@PathVariable String order_id, @PathVariable String status) {
        return "ChangeOrderStatus " + order_id + " " + status;
    }
}

//GET - api/warehouse/items
//GET - api/warehouse/items/{item_id}
//POST - api/warehouse/items
//PUT - api/warehouse/items/{id}/addition/{amount}
//GET - api/orders
//GET - api/orders/{order_id}
//PUT - api/orders/{order_id}/addition
//PUT - api/orders/{order_id}/pay
//PUT - api/orders/{order_id}/status/{status}

//@RestController
//public class Gateway {
//    public static class RestResponse {
//        private String param;
//
//        public String getParam() {
//            return param;
//        }
//
//        public void setParam(String param) {
//            this.param = param;
//        }
//    }
//
//    @RequestMapping(value = "/test", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public RestResponse restMethod(String name){
//        RestResponse result = new RestResponse();
//        result.setParam(name);
//        return result;
//    }
//}



//@Data
//class Item {
//    private String id;
//}
//
//
//@RestController
//class GetItemController {
//
//    private final WebClient.Builder itemClient;
//
//    public GetItemController(WebClient.Builder itemClient) {
//        this.itemClient = itemClient;
//    }
//
//    @RequestMapping(
//            value = "/warehouse/items",
//            method = RequestMethod.GET,
//            headers = "Accept=application/json")
//    @ResponseBody
//    public Flux<Item> GetItem() {
//        return itemClient.build().get().uri("8080://item-service/item")
//                .retrieve().bodyToFlux(Item.class);
//    }
//}