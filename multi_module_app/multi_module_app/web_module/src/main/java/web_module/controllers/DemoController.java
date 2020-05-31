package web_module.controllers;

import org.moduleone.App;
import org.module_two.AppTwo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/module")
public class DemoController {

	
	  @RequestMapping("/one")
	  @ResponseBody
	  public String displayOne() { 
		  App demoapp = new App();
		  return demoapp.print();
	  }
	 
	
	@RequestMapping("/two")
	@ResponseBody
	public String displayTwo() {
		AppTwo demoapp = new AppTwo();
		return demoapp.print();
	}
	
	// to get current weather status in india
	@RequestMapping("/weather")
	@ResponseBody
	public Object getWeather() {
		AppTwo demoapp = new AppTwo();
		return demoapp.getWeather();
	}
	
	
}
