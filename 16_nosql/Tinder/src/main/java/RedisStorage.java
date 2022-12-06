import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;


import static java.lang.System.out;

public class RedisStorage {

    private RedissonClient redisson;

    private RKeys rKeys;

    private RScoredSortedSet<String> users;

    private final static String KEY = "USERS";

    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for(String key: keys) {
            out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        users = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    void addUser(int score, String userId)
    {
        users.add(score, userId);
    }

    void deleteUser(String userId) {

    }

    public void listUsers() {
        for (String user : users) {
            out.println(" - User " + user);
        }
    }

    public String getUserByScore(int score) {
        return users.valueRange(score, true, score + 1, false).stream().findAny().get();
    }

    public int getUserScore(String userId) {
        return (int)Math.round(users.getScore(userId));
    }

    public void setUserScore(int score, String userId) {
        users.addAndGetRank(score, userId);
    }

    public void setScoreByRange(int begin, int end) {

    }

}
