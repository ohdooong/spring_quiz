package com.quiz.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.store.bo.StoreBO;
import com.quiz.store.domain.Store;

@RequestMapping("/store")
@Controller
public class StoreController {
	
	@Autowired
	private StoreBO storeBO;
	
	// URL : http://localhost/store/store-view
	@GetMapping("/store-view")
	public String storeView (Model model) {
		
		List<Store> stores = new ArrayList<>();
		
		stores = storeBO.getStores();
		
		model.addAttribute("stores", stores);
	
		return "store/storeMain";
	}
	
	@GetMapping("/review-list")
	public String reviewList (
			@RequestParam("storeId") int storeId,
			@RequestParam("storeName") int storeName) {
		
		
		return "store/reviewList";
	}
	
	
	
}
