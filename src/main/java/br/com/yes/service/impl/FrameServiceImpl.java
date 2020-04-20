package br.com.yes.service.impl;

import br.com.yes.domain.Frame;
import br.com.yes.domain.FrameWrapper;
import br.com.yes.service.FrameService;

import java.util.ArrayList;
import java.util.List;

public class FrameServiceImpl implements FrameService {

    @Override
    public FrameWrapper addFrame(String name, List<Integer> points) {
        final List<Integer> aux = new ArrayList<>(2);
        final FrameWrapper frameWrapper = new FrameWrapper();

        for (Integer value : points) {
            if (frameWrapper.lastTurn()) {
                aux.add(value);
                if (aux.size() == 3) {
                    frameWrapper.add(
                            this.buildFrame(name, aux.get(0), aux.get(1), aux.get(2), true));
                }
                continue;
            }

            if (value == 10) {
                frameWrapper.add(this.buildFrame(name, value));
                continue;
            }

            aux.add(value);
            if (aux.size() == 2) {
                frameWrapper.add(this.buildFrame(name, aux.get(0), aux.get(1)));
                aux.clear();
            }
        }
        return frameWrapper;
    }

    private Frame buildFrame(final String name, final int first) {
        return this.buildFrame(name, first, 0, 0, false);
    }

    private Frame buildFrame(final String name, final int first, int second) {
        return this.buildFrame(name, first, second, 0, false);
    }

    private Frame buildFrame(final String name, final int first, int second, int third, boolean last) {
        return Frame.builder()
                .name(name)
                .firstShot(first)
                .secondShot(second)
                .thirdShot(third)
                .lastFrame(last)
                .build();
    }
}
