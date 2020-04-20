package br.com.yes.service.impl;

import br.com.yes.domain.FrameWrapper;
import br.com.yes.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FrameServiceImplTest extends TestCase {

    @InjectMocks
    private FrameServiceImpl frameService;


    @Test
    public void testAddFrameWith20Values() {
        final FrameWrapper ofMary = this.frameService.addFrame("Mary", TestUtil.values(21))
                .updateTotalPoints();

        assertNotNull(ofMary.retrieveFrames());
        assertEquals(10, ofMary.retrieveFrames().size());
        assertEquals(3, ofMary.retrieveFrames().getFirst().getTotalPoints());
    }

    @Test
    public void testAddFrameWithMoreThan20Values() {
        final FrameWrapper ofMary = this.frameService.addFrame("Mary", TestUtil.values(41))
                .updateTotalPoints();

        assertNotNull(ofMary.retrieveFrames());
        assertEquals(10, ofMary.retrieveFrames().size());
        assertEquals(3, ofMary.retrieveFrames().getFirst().getTotalPoints());
    }

    @Test
    public void testAddFrameWithIncomplete() {
        final FrameWrapper ofMary = this.frameService.addFrame("Mary", TestUtil.values(4))
                .updateTotalPoints();

        assertNotNull(ofMary.retrieveFrames());
        assertEquals(1, ofMary.retrieveFrames().size());
        assertEquals(3, ofMary.retrieveFrames().getFirst().getTotalPoints());
    }
}