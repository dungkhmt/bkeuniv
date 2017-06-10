package vn.webapp.modules.researchdeclarationmanagement.controller.cpservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.webapp.controller.BaseRest;
import vn.webapp.dto.Response;

@Controller("cpmServicePaper")
@RequestMapping(value = {"/cpservice"})
public class PaperController extends BaseRest {
	
	@ResponseBody
    @RequestMapping(value = "generate", method = RequestMethod.POST)
    public Response generatePaperXls() {
    	//TODO
        int res = 1;
        if (res > 0) {
            return new Response(true, "Add successfully.", res);
        } else {
            return new Response(false, "Add unsuccessfully. Please try again.", res);
        } 
    }
}
