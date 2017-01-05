package main.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.pojo.UserInfo;
import main.java.pojo.UserInfo.Destinacija;
import main.java.pojo.UserInfo.TipRizika;

@RestController
@RequestMapping("/package")
public class PackageController {

	@RequestMapping(value="/setPackages", method=RequestMethod.POST)
	public @ResponseBody UserInfo setPackagePrice(@Context HttpServletRequest req) throws Exception{
		 KieServices ks = KieServices.Factory.get();
	     KieContainer kContainer = ks.getKieClasspathContainer();
	     KieSession kSession =  kContainer.newKieSession(); 
	     
	     UserInfo item1 = new UserInfo();
	     item1.setTipRizika(TipRizika.SLAB);
	     item1.setDestinacija(Destinacija.SRBIJA);
	     item1.setBrDana(3);
	     item1.setBrDece(2);
	     item1.setBrOdraslih(2);
	     item1.setKoefDece(0.3);
	     item1.setKoefOdraslih(0.4);
	     item1.setKoefDestinacije(0.1);
	     item1.setKoefRizika(0.7);
	     kSession.insert(item1);
	     kSession.fireAllRules();
	     
		return item1;
		
	}
	
}