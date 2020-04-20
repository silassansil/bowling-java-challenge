package br.com.yes.service;

import br.com.yes.domain.FrameWrapper;

import java.util.List;

public interface FrameService {

    FrameWrapper addFrame(final String name, final List<Integer> points);
}
