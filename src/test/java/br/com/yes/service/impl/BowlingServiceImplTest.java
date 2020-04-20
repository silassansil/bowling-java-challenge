package br.com.yes.service.impl;

import br.com.yes.domain.FrameWrapper;
import br.com.yes.service.FileReader;
import br.com.yes.service.FrameService;
import br.com.yes.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BowlingServiceImplTest extends TestCase {

    @Mock
    private FileReader fileReader;

    @Mock
    private FrameService frameService;

    @InjectMocks
    private BowlingServiceImpl bowlingService;

    @Test
    public void testCalculateScore() {
        //when
        when(this.fileReader.read(null))
                .thenReturn(TestUtil.dumpFrames("Carl", 21));

        when(this.frameService.addFrame(anyString(), any()))
                .thenReturn(new FrameWrapper());

        this.bowlingService.calculateScore();
    }

    @Test
    public void testCalculateScoreWhenEmptyFramesList() {
        //when
        when(this.fileReader.read(anyString()))
                .thenReturn(TestUtil.dumpFrames("Carl", 0));

        when(this.frameService.addFrame(anyString(), any()))
                .thenReturn(new FrameWrapper());

        this.bowlingService.calculateScore();
    }

    @Test
    public void testCalculateScoreWithStrike() {
        //when
        when(this.fileReader.read(anyString()))
                .thenReturn(TestUtil.dumpFrames("Carl", 10, 10, 10, 0, 1, 4));

        when(this.frameService.addFrame(anyString(), any()))
                .thenReturn(new FrameWrapper());

        this.bowlingService.calculateScore();
    }

    @Test
    public void testCalculateScoreWithSpare() {
        //when
        when(this.fileReader.read(anyString()))
                .thenReturn(TestUtil.dumpFrames("Carl", 3, 7, 10, 0, 1, 4));

        when(this.frameService.addFrame(anyString(), any()))
                .thenReturn(new FrameWrapper());

        this.bowlingService.calculateScore();
    }
}