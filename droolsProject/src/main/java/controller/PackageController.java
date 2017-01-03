package controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pojo.UserInfo;
import pojo.UserInfo.Destinacija;
import pojo.UserInfo.TipRizika;

@RestController
@RequestMapping("/package")
public class PackageController {

	@RequestMapping(value="/setPackages", method=RequestMethod.POST)
	public @ResponseBody UserInfo setPackagePrice(@Context HttpServletRequest req) throws Exception{
		 KieServices ks = KieServices.Factory.get();
	     KieContainer kContainer = ks.getKieClasspathContainer();
	     KieSession kSession =  kContainer.newKieSession(); 
	     
	     UserInfo item = new UserInfo();
	     item.setTipRizika(TipRizika.SLAB);
	     item.setDestinacija(Destinacija.SRBIJA);
	     kSession.insert(item);
	     kSession.fireAllRules();
	     
		return item;
		
	}
	
}
