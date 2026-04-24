package airport.models;

import java.time.LocalDateTime;

public class BoardingPass {
    private String id;
    private Ticket ticket;
    private String gate;
    private String time;

    public BoardingPass(String boardingPassId, Ticket ticket, String gate, LocalDateTime time) {
        this.id = boardingPassId;
        this.ticket = ticket;
        this.gate = gate;
        this.time = time.toString();
    }

    public boolean generateBoardingPass() {
        return true;
    }
}