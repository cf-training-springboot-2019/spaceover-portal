package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.model.CrewMember;
import com.springboot.training.spaceover.spaceover.portal.domain.model.SpaceMission;
import com.springboot.training.spaceover.spaceover.portal.domain.model.SpaceShip;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class SpaceOverModelService implements SpaceOverService {

    private final SpaceShipClient spaceShipClient;

    private final SpaceMissionClient spaceMissionClient;

    private final SpaceCrewMemberClient spaceCrewMemberClient;

    private final ModelMapper modelMapper;

    @Override
    public void getSpaceShips(Model model) {
        List<SpaceShip> spaceShips = spaceShipClient.findSpaceShips().stream()
                .map(s -> modelMapper.map(s, SpaceShip.class))
                .collect(Collectors.toList());
        model.addAttribute("spaceships", spaceShips);
    }

    @Override
    public void getSpaceMissions(Model model) {
        List<SpaceMission> spaceMissions = spaceMissionClient.findSpaceMissions().stream()
                .map(s -> modelMapper.map(s, SpaceMission.class))
                .collect(Collectors.toList());
        model.addAttribute("missions", spaceMissions);

    }

    @Override
    public void getSpaceCrewMembers(Model model) {
        List<CrewMember> crewMembers = spaceCrewMemberClient.findSpaceCrewMembers().stream()
                .map(s -> modelMapper.map(s, CrewMember.class))
                .collect(Collectors.toList());
        model.addAttribute("crewmembers", crewMembers);
    }
}
