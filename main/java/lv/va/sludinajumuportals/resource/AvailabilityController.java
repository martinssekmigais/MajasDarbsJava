package lv.va.sludinajumuportals.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AvailabilityController {
    public String status = "503 Service Unavailable";
    public String Post = "<form method=\"post\" action=\"\" class=\"inline\">" +
            "  <button type=\"submit\"  class=\"link-button\">\n" +
            "    method=post\n" +
            "  </button>\n" +
            "</form>";
    public String Get = "<form method=\"get\" action=\"\" class=\"inline\">" +
            "  <button type=\"submit\"  class=\"link-button\">\n" +
            "    method=get\n" +
            "  </button>\n" +
            "</form>";

    @GetMapping(value = "/{kd}")
    @ResponseBody
    public String getStatus(@PathVariable String kd) {
        return status+"</br>  PathVariable="+kd+Post+Get;

    }


    @PostMapping(value = "/{kd}")
    @ResponseBody
    public String setStatus(@PathVariable String kd) {
        switch (status) {
            case "503 Service Unavailable":
                status = "200 OK";
                break;
            case "200 OK":
                status = "503 Service Unavailable";
                break;
            default:
                status = "default";
                break;
        }

        return status+"</br>  PathVariable="+kd+Post+Get;
    }
}