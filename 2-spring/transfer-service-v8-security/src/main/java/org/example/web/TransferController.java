package org.example.web;

import java.security.Principal;

import org.example.dto.TransferRequest;
import org.example.service.TransferService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;

    @GetMapping()
    public String transferForm(Principal principal) {
        // System.out.println(principal);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        authentication.getAuthorities().stream().forEach(System.out::println);

        return "redirect:transfer-form.html";
    }

    @PostMapping
    public ModelAndView doTransfer(
            // @RequestParam("amount") double amount,
            // @RequestParam("source") String sourceAccount,
            // @RequestParam("destination") String destinationAccount
            @ModelAttribute TransferRequest transferRequest,
            BindingResult result) {

        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()) {
            mav.setViewName("redirect:transfer-form.html");
        } else {

            transferService.transfer(transferRequest.getAmount(), transferRequest.getSource(),
                    transferRequest.getDestination());
            String model = "transfer-success";
            mav.addObject("message", model);
            mav.setViewName("redirect:transfer-status.html");
        }

        return mav;
    }

}
