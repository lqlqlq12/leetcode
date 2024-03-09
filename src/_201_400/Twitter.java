package _201_400;

import org.junit.Test;

import java.util.*;

//355.设计推特
/*设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。

实现 Twitter 类：

Twitter() 初始化简易版推特对象
void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。*/
//感觉挺水的 用一个tweet类 内部成员变量tweetId和发布日期index[0:n](第几个发布推特的)
//然后用一个Map<Integer,Queue<Tweet>> 记录每一个userId对应发的推特 Queue根据index降序排序 也就是从最近到很久以前
//再用一个Map<Integer,List<Integer>> 表示uerId的用户关注了哪些userId
//getNewsFeed时 关注了几个人 就用几个指针去遍历他们的推特 然后index大的先选
public class Twitter {
    class Tweet {
        int tweetId, index;

        Tweet(int tweetId, int index) {
            this.tweetId = tweetId;
            this.index = index;
        }
    }

    Map<Integer, List<Tweet>> publish;
    Map<Integer, List<Integer>> follow;
    int index;

    public Twitter() {
        publish = new HashMap<>();
        follow = new HashMap<>();
        index = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!publish.containsKey(userId)) {
            publish.put(userId, new LinkedList<>());
        }
        publish.get(userId).add(0, new Tweet(tweetId, index++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> re = new ArrayList<>();
        List<Integer> ids = follow.getOrDefault(userId, new ArrayList<>());
        Iterator<Tweet>[] point = new Iterator[ids.size() + 1];
        Tweet[] tweets = new Tweet[ids.size() + 1];
        point[0] = publish.getOrDefault(userId, new LinkedList<>()).iterator();
        if (point[0].hasNext()) tweets[0] = point[0].next();
        for (int i = 0; i < ids.size(); i++) {
            point[i + 1] = publish.getOrDefault(ids.get(i), new LinkedList<>()).iterator();
            if (point[i + 1].hasNext()) {
                tweets[i + 1] = point[i + 1].next();
            }
        }
        for (int i = 0; i < 10; i++) {
            int select = -1, early = -1;
            for (int j = 0; j < tweets.length; j++) {
                if (tweets[j] == null) continue;
                if (early < tweets[j].index) {
                    select = j;
                    early = tweets[j].index;
                }
            }
            if (select == -1) return re;
            re.add(tweets[select].tweetId);
            if (point[select].hasNext()) tweets[select] = point[select].next();
            else tweets[select] = null;
        }
        return re;
    }

    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) {
            follow.put(followerId, new ArrayList<>());
        }
        if (follow.get(followerId).contains(followeeId)) {
            return;
        }
        follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) return;
        follow.get(followerId).remove(Integer.valueOf(followeeId));
    }

    //[[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1]]
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
    }
}
