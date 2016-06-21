package demo.mysql.redisTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import demo.mysql.util.RedisApi;


public class redisTest {

	public static void main(String[] args) {
		System.out.println(RedisApi.get("aa"));
		JedisPool jedisPool = RedisApi.getPool();
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			System.out.println(jedis.set("izhongwei", "ixiazhongwei"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		
	}

}
