package com.springboot.training.spaceover.spaceover.portal.controller;

import com.springboot.training.spaceover.spaceover.portal.domain.model.CrewMember;
import com.springboot.training.spaceover.spaceover.portal.domain.model.SpaceFleet;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceCrewMemberStatus;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceCrewMemberRole;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceFleetStatus;
import com.springboot.training.spaceover.spaceover.portal.service.SpaceOverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class WebAppController {

    /**
     * Main Pages
     */

    private final SpaceOverService spaceOverService;


    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/spacefleets")
    public String spaceFleets(Model model) {
        model.addAttribute("spacefleets", Arrays.asList(
                SpaceFleet.builder().id(1l).name("SpaceFleetOne").sector("Alpha-3").status(SpaceFleetStatus.ACTIVE).build(),
                SpaceFleet.builder().id(2l).name("SpaceFleetOne").sector("Alpha-4").status(SpaceFleetStatus.ACTIVE).build(),
                SpaceFleet.builder().id(3l).name("SpaceFleetOne").sector("Alpha-1").status(SpaceFleetStatus.ACTIVE).build()
        ));
        return "spacefleets";
    }

    @RequestMapping("/spaceships")
    public String spaceShips(Model model) {
        spaceOverService.getSpaceShips(model);
        return "spaceships";
    }

    @RequestMapping("/crewmembers")
    public String crewMembers(Model model) {
        spaceOverService.getSpaceCrewMembers(model);
        return "crewmembers";
    }

    @RequestMapping("/missions")
    public String missions(Model model) {
        spaceOverService.getSpaceMissions(model);
        return "missions";
    }


    /**
     * Interface Pages
     */

    @RequestMapping("/buttons")
    public String buttons(Model model) {
        return "buttons";
    }

    @RequestMapping("/cards")
    public String cards(Model model) {
        return "cards";
    }

    @RequestMapping("/colors")
    public String colors(Model model) {
        return "utilities-color";
    }

    @RequestMapping("/borders")
    public String borders(Model model) {
        return "utilities-border";
    }

    @RequestMapping("/others")
    public String others(Model model) {
        return "utilities-other";
    }

    @RequestMapping("/animations")
    public String animations(Model model) {
        return "utilities-animation";
    }

    /**
     * Support Pages
     */

    @RequestMapping("/tables")
    public String tables(Model model) {
        return "tables";
    }

    @RequestMapping("/charts")
    public String charts(Model model) {
        return "charts";
    }

    @RequestMapping("/blank")
    public String blank(Model model) {
        return "blank";
    }

    @RequestMapping("/notFound")
    public String notFound(Model model) {
        return "404";
    }


    @RequestMapping("/forgotPassword")
    public String forgotPassword(Model model) {
        return "forgot-password";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }

}