package nammi.rule.engine.drools.controlller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import nammi.rule.engine.drools.DimService;

@Controller
@RequestMapping(value = "/dim/*")
public class DimController {
	
	@Resource
	private DimService dimService;

}
