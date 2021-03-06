package main.java.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import main.java.entity.Continent;
import main.java.entity.InsurancePackage;
import main.java.entity.PricelistItem;
import main.java.pojo.UserInfo;
import main.java.pojo.UserInfo.Destinacija;
import main.java.pojo.UserInfo.TipRizika;
import main.java.service.Service;

@CrossOrigin
@RestController
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
	private Service<Continent, Integer> continetService;
	
	@Autowired
	private Service<InsurancePackage, Integer> packageService;
	
	@Autowired
	private Service<PricelistItem, Integer> priceListItemService;
	
	
	@RequestMapping(value="/setPackages", method=RequestMethod.POST)
	public @ResponseBody UserInfo setPackagePrice(@Context HttpServletRequest req) throws Exception{
		 KieServices ks = KieServices.Factory.get();
	     KieContainer kContainer = ks.getKieClasspathContainer();
	     KieSession kSession =  kContainer.newKieSession(); 
	     
	     /*
	      * Ovde trebam dobaviti podatke iz baze (dest, tip rizika, koef...)
	      * pa podatke sa fronta
	      * 
	      */
	   /*  Continent cont = new Continent();
	     cont.setContinentName("Evropa");
	     continetService.add(cont);
	     */
	     List<InsurancePackage> dostupniPaketi = packageService.getAll("InsurancePackage");
	     List<PricelistItem> cenaPaketa = new ArrayList<PricelistItem>();
	     
	     for(InsurancePackage pak: dostupniPaketi){
	    	 Integer id = pak.getPricelistItem().getPlItemId();
	    	 PricelistItem item = priceListItemService.findById(id, new PricelistItem());
	    	 cenaPaketa.add(item);
	     }
	     
	     UserInfo item1 = new UserInfo();
	     BigDecimal kRiz = new BigDecimal("1.25");
	     item1.setTipRizika(TipRizika.SLAB);
	     item1.setDestinacija(Destinacija.SRBIJA);
	     item1.setBrDana(3);
	     item1.setBrDece(2);
	     item1.setBrOdraslih(2);
	     item1.setKoefDece(1.568);
	     item1.setKoefOdraslih(0.4);
	     item1.setKoefDestinacije(0.1);
	     item1.setKoefRizika(kRiz);
	     item1.setOsnovica1(cenaPaketa.get(0).getPlPrice());
	     item1.setOsnovica2(cenaPaketa.get(1).getPlPrice());
	     item1.setOsnovica3(cenaPaketa.get(2).getPlPrice());
	     kSession.insert(item1);
	     kSession.fireAllRules();
	     
		return item1;
		
	}
	
}
