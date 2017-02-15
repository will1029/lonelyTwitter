package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by watts1 on 1/28/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }


    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last Tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testStrings() {
        assertEquals("'test should be 'test'", "test", "test");
        //assertTrue("'test' should start w/ 't'", "test", "test".startsWith("T"));
    }

    public void testDuplicates() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last Tweet");

        /* Uncomment to test for duplicate by adding a tweet into the list */
        //tweets.addTweet(tweet);

        assertTrue(tweets.addTweet(tweet));
    }

    public void testCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("First Tweet");
        Tweet tweet2 = new NormalTweet("Last Tweet");
        int count = 2;

        tweets.addTweet(tweet);
        tweets.addTweet(tweet2);

        assertEquals(tweets.getCount(), count);
    }
}
