package br.com.yes.service.impl;

import br.com.yes.service.BowlingService;
import br.com.yes.service.FileReader;
import br.com.yes.service.FrameService;

public class BowlingServiceImpl implements BowlingService {

    private final FileReader fileReader;
    private final FrameService frameService;
    private final String pathFile;

    public BowlingServiceImpl(FileReader fileReader,
                              FrameService frameService,
                              String pathFile) {
        this.fileReader = fileReader;
        this.frameService = frameService;
        this.pathFile = pathFile;
    }

    @Override
    public void calculateScore() {
        this.fileReader.read(this.pathFile).forEach((name, values) ->
                System.out.println(
                        this.frameService
                                .addFrame(name, values)
                                .updateTotalPoints()
                                .toString()));

    }
}
