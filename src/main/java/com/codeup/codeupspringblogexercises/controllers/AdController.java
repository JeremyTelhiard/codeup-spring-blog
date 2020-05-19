//package com.codeup.codeupspringblogexercises.controllers;
//
//import com.codeup.codeupspringblogexercises.controllers.models.Ad;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class AdController {
//
//
//    @GetMapping("/ads")
//    public String showAds(Model model){
//        List<Ad> adList = new ArrayList<>();
//        Ad ad = new Ad("1967 Buick Wildcat", "Cherry car");
////        ad = @7x54
//        adList.add(ad);
//        ad = new Ad("Wooden desk", "Rolltop");
//        adList.add(ad);
//        model.addAttribute("ads", adList);
//        return "ads/index";
//    }
//
//    @GetMapping("/ad")
//    public String showAd(Model model){
//        Ad ad = new Ad("1967 Buick Wildcat", "Cherry car");
//        model.addAttribute("ad", ad);
//        return "ads/show";
//    }
//
//
//    @GetMapping("/ads/create")
//    public String goToCreateAdsForm(Model model){
//        return "ads/create";
//    }
//
//    @PostMapping("/ads/create")
//    public String createAd(@RequestParam(name = "title") String title,
//                           @RequestParam(name ="description") String description,
//                           Model model){
//        Ad ad = new Ad(title, description);
//        model.addAttribute("ad", ad);
//        return "ads/show";
//    }
//

//-----------------------------------------

//@GetMapping("/ads/{id}")
//public String showAd(@PathVariable long id, Model model) {
//        model.addAttribute("ad", adDao.getOne(id));
//        return "ads/show";
//        }

//@GetMapping("/ads/{id}/edit")
//public String editAdForm(@PathVariable long id, Model model) {
//        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (obj == null || !(obj instanceof UserDetails)) {
//        return "redirect:/login";
//        }
//        User user = (User) obj;
//        Ad ad = adDao.getOne(id);
//        if (ad.getUser().getId() != user.getId()) {
//        return "redirect:/ads/" + ad.getId();
//        }
//        model.addAttribute("ad", ad);
//        return "/ads/edit";
//        }


//@PostMapping("/ads/{id}/edit")
//public String editAdWithId(@PathVariable long id, @ModelAttribute Ad ad) {
//        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (obj == null || !(obj instanceof UserDetails)) {
//        return "redirect:/login";
//        }
//        User user = (User) obj;
//        ad.setId(id);
//        ad.setUser(user);
//        adDao.save(ad);
//        emailService.prepareAndSend(ad, "EDITED Ad: " + ad.getTitle(),
//        ad.getTitle() +"\n\n" +
//        ad.getDescription());
//        return "redirect:/ads/" + ad.getId();
//        }



//@PostMapping("/ads/{id}/delete")
//public String deleteAd(@PathVariable long id, Model model) {
//        System.out.println(id);
//        adDao.deleteById(id);
//        return "redirect:/ads";
//        }
//
//}
