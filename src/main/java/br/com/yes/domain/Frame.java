package br.com.yes.domain;

import br.com.yes.enums.PinFallType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Frame {

    @Builder
    public Frame(String name, int firstShot, int secondShot, int thirdShot, int totalPoints, boolean lastFrame, Frame prev, Frame next) {
        this.name = name;
        this.firstShot = firstShot;
        this.secondShot = secondShot;
        this.thirdShot = thirdShot;
        this.totalPoints = totalPoints;
        this.lastFrame = lastFrame;
        this.prev = prev;
        this.next = next;
        this.type = PinFallType.performType(firstShot, secondShot);
    }

    private final String name;
    private final PinFallType type;
    private final boolean lastFrame;

    private int firstShot;
    private int secondShot;
    private int thirdShot;
    private int totalPoints;

    private Frame prev;
    private Frame next;

    public void calculateTotalPoints() {
        this.totalPoints = this.totalPoints + this.summationTotalPinFalls();
        if (this.prev != null) this.totalPoints = this.totalPoints + this.prev.totalPoints;
        if (this.next != null) this.totalPoints = this.totalPoints + this.type.addScore(this.next);
    }

    public Integer summationTotalPinFalls() {
        return this.firstShot + this.secondShot + this.thirdShot;
    }

    public Integer partialSummationTotalPinFalls() {
        return this.firstShot + this.secondShot;
    }

    public Integer summationNextFirstsWhenHappenConsecutiveStrikes() {
        return this.firstShot + this.next.firstShot;
    }

    public void addPrevFrame(Frame prev) {
        this.prev = prev;
    }

    public void addNextFrame(Frame next) {
        this.next = next;
    }

}
