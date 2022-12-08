package chess.engine.models.players;

import chess.engine.models.Alliance;

public abstract class Player {

    private Alliance alliance;

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
    public Alliance getAlliance() {
        return this.alliance;
    }

}
