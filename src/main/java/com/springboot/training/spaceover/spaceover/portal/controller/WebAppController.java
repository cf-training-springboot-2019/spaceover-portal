package com.springboot.training.spaceover.spaceover.portal.controller;

import com.springboot.training.spaceover.spaceover.portal.domain.model.CrewMember;
import com.springboot.training.spaceover.spaceover.portal.domain.model.SpaceFleet;
import com.springboot.training.spaceover.spaceover.portal.domain.model.SpaceMission;
import com.springboot.training.spaceover.spaceover.portal.domain.model.SpaceShip;
import com.springboot.training.spaceover.spaceover.portal.enums.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class WebAppController {

    /**
     *  Main Pages
     */

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
        model.addAttribute("spaceships", Arrays.asList(
                SpaceShip.builder().id(1l).name("Millennium Falcon").status(SpaceShipStatus.ACTIVE).maxOccupancy(BigInteger.TEN).spaceFleetId(1l).type(SpaceShipType.CRUISER).build(),
                SpaceShip.builder().id(2l).name("Red Fox").status(SpaceShipStatus.ACTIVE).maxOccupancy(BigInteger.ONE).spaceFleetId(1l).type(SpaceShipType.CRUISER).build(),
                SpaceShip.builder().id(3l).name("Death Start").status(SpaceShipStatus.ACTIVE).maxOccupancy(BigInteger.valueOf(10000l)).spaceFleetId(2l).type(SpaceShipType.CRUISER).build()
        ));
        return "spaceships";
    }

    @RequestMapping("/crewmembers")
    public String crewMembers(Model model) {
        model.addAttribute("crewmembers", Arrays.asList(
                CrewMember.builder().id(1l).name("Han Solo").spaceShipId(1l).status(CrewMemberStatus.ACTIVE).role(CrewRole.CAPTAIN).build(),
                CrewMember.builder().id(2l).name("Harry Potter").spaceShipId(2l).status(CrewMemberStatus.ACTIVE).role(CrewRole.WIZARD).build()
        ));
        return "crewmembers";
    }

    @RequestMapping("/missions")
    public String missions(Model model) {
        model.addAttribute("missions", Arrays.asList(
                SpaceMission.builder().id(1l).name("Save Private Ryan").revenue(BigDecimal.ZERO).status(SpaceMissionStatus.IN_PROGRESS).spaceShipId(1l).build(),
                SpaceMission.builder().id(1l).name("Blow up Death Star").revenue(BigDecimal.TEN).status(SpaceMissionStatus.FINISHED).spaceShipId(2l).build()
        ));
        return "missions";
    }



    /**
     *  Interface Pages
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
     *  Support Pages
     */

    @RequestMapping("/tables")
    public String tables(Model model) { return "tables"; }

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