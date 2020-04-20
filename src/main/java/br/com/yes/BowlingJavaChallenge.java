package br.com.yes;

import br.com.yes.service.impl.BowlingServiceImpl;
import br.com.yes.service.impl.FileReaderImpl;
import br.com.yes.service.impl.FrameServiceImpl;

public class BowlingJavaChallenge {

    public static void main(String[] args) {
        if (args.length < 1) throw new RuntimeException("path file is mandatory");

        final BowlingServiceImpl bowlingService = new BowlingServiceImpl(
                new FileReaderImpl(),
                new FrameServiceImpl(),
                args[0]);

        bowlingService.calculateScore();
    }
}
