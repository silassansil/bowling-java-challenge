package br.com.yes.domain;

import br.com.yes.formatter.FrameFormatter;

import java.util.Deque;
import java.util.LinkedList;

public class FrameWrapper {
    private final Deque<Frame> frames = new LinkedList<>();

    public void add(final Frame frame) {
        if (!frames.isEmpty()) {
            frame.addPrevFrame(frames.getLast());
            frames.getLast().addNextFrame(frame);
        }
        frames.add(frame);
    }

    public FrameWrapper updateTotalPoints() {
        this.frames.forEach(Frame::calculateTotalPoints);
        return this;
    }

    public boolean lastTurn() {
        return frames.size() == 9;
    }

    public Deque<Frame> retrieveFrames() {
        return frames;
    }

    @Override
    public String toString() {
        return FrameFormatter.format(this.frames);
    }
}
