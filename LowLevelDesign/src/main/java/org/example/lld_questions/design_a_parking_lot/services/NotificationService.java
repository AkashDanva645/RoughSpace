package org.example.lld_questions.design_a_parking_lot.services;

import org.example.lld_questions.design_a_parking_lot.external.DisplayPanel;

import java.util.HashMap;
import java.util.Map;

public class NotificationService {

    Map<Integer, DisplayPanel> displayPanels = new HashMap<>();

    public void sendNotification(int floor, String message) {
        displayPanels.get(floor).changeMessage(message);
    }

    public void addDisplayPanel(DisplayPanel dp) {
        displayPanels.put(dp.getFloorId(), dp);
    }
}
