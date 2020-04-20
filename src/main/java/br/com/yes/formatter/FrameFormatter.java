package br.com.yes.formatter;

import br.com.yes.domain.Frame;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrameFormatter {

    private FrameFormatter() {
        throw new IllegalStateException("Utility Class");
    }

    public static String format(final Collection<Frame> frames) {
        return header(frames) + "\n" + playerName(frames) + "\n" + pinFalls(frames) + "\n" + score(frames) + "\n==============================\n";
    }

    private static String header(Collection<Frame> frames) {
        return "Frame\t\t" + IntStream.range(1, frames.size() + 1)
                .mapToObj(Objects::toString)
                .collect(Collectors.joining("\t\t\t"));
    }

    private static String playerName(Collection<Frame> frames) {
        return frames
                .stream()
                .map(Frame::getName)
                .findFirst()
                .orElse("");
    }

    private static String pinFalls(Collection<Frame> frames) {
        return "Pinfalls\t" + frames
                .stream()
                .map(frame -> String.format("%s", formatValues(frame)))
                .collect(Collectors.joining("\t\t"));
    }

    private static String score(Collection<Frame> frames) {
        return "Score\t\t" + frames
                .stream()
                .map(frame -> String.format("%s", frame.getTotalPoints()))
                .collect(Collectors.joining("\t\t\t"));
    }

    private static String formatValues(final Frame frame) {
        if (frame.isLastFrame()) {
            return String.format("%d | %d | %d",
                    frame.getFirstShot(),
                    frame.getSecondShot(),
                    frame.getThirdShot())
                    .replace("10", "X");

        } else if (frame.getType().isStrike()) {
            return " | X ";

        } else if (frame.getType().isSpare()) {
            return frame.getFirstShot() + " | / ";

        } else {
            return String.format("%d | %d", frame.getFirstShot(), frame.getSecondShot());
        }
    }
}
