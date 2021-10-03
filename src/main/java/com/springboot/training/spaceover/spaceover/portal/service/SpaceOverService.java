package com.springboot.training.spaceover.spaceover.portal.service;

import org.springframework.ui.Model;

public interface SpaceOverService {
    void getSpaceShips(Model model);
    void getSpaceMissions(Model model);
    void getSpaceCrewMembers(Model model);

}
