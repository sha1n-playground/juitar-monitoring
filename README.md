Juitar-Monitoring
=================
This repository plays with Java monitoring and flow tracking utilities based on aspects implemented using [AspectJ](http://www.eclipse.org/aspectj/).

If you are looking for something serious, this is not it. This repo is used mainly to play with ideas and learn technologies only.
[Perf4J](https://github.com/perf4j/perf4j) is a project which contains a more serious implementation of similar concepts.

Usage example:
-------------

    @Monitored(threshold = 10)
    @Override
    public Result doWork(Work work) {

        String[] payload = (String[]) work.getPayload();
        int[] ints = jdbcTemplate.batchUpdate(payload);

        Result result = new Result(work.getId());
        result.setResultData(ints);

        return result;
    }
