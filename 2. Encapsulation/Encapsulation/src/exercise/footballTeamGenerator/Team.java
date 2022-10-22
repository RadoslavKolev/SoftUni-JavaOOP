package exercise.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Player.validateName(name);
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isRemoved = this.players
                .removeIf(p -> p.getName().equals(playerName));

        if (!isRemoved) {
            String exceptionMessage = String.format(
                    "Player %s is not in %s team.",
                    playerName, this.name
            );

            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public double getRating() {
        return this.players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0);
    }
}
