/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int pos = 0;
        //find the position where we insert new interval
        while (pos < intervals.size() && intervals.get(pos).end < newInterval.start) {
            res.add(intervals.get(pos));
            pos++;
        }
        //the last position to insert
        if (pos == intervals.size()) {
            res.add(newInterval);
            return res;
        }
        //insert new Interval
        res.add(newInterval);
        //detect if there are overlap area, if there is merge them, otherwise add to res
        for (int i = pos; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            //the precondition here is that cur.end >= newInterval.start, so the condition
            //that they have overlap is cur.start <= newInterval.end
            if (cur.start <= newInterval.end) {
                //merge two interval
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
            } else {
                res.add(cur);
            }
        }
        return res;
    }
}