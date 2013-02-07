package org.juitar.monitoring.api;

/**
 * @author sha1n
 * Date: 2/7/13
 */
public class MethodInvocationProbe {

    private volatile TimeFrameCounter currentProbe;
    private volatile int lastCount = 0;

    public MethodInvocationProbe(final long timeFrame) {
        this.currentProbe = new TimeFrameCounter(timeFrame, System.currentTimeMillis());
    }

    public final boolean hit() {
        long hitStamp = System.currentTimeMillis();
        TimeFrameCounter timeFrameCounter = currentProbe.hit(hitStamp);
        boolean update = timeFrameCounter != currentProbe;
        if (update) {
            lastCount = currentProbe.hitCount;
        }
        currentProbe = timeFrameCounter;


        return update;
    }

    public final int getLastInvocationCount() {
        return lastCount;
    }

    public final int getInvocationCount() {
        return currentProbe.hitCount;
    }

    private static final class TimeFrameCounter {

        private final long timeFrame;
        private final long frameStartStamp;
        private int hitCount = 0;

        TimeFrameCounter(final long timeFrame, final long frameStartStamp) {
            this.timeFrame = timeFrame;
            this.frameStartStamp = frameStartStamp;
        }

        public final TimeFrameCounter hit(final long hitStamp) {
            TimeFrameCounter next = this;

            if (frameStartStamp <= (hitStamp - timeFrame)) {
                next = new TimeFrameCounter(timeFrame, hitStamp);
                next.hitCount = 1;
            } else {
                hitCount++;
            }

            return next;
        }

    }

}
