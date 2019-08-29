package com.zj.redis.conf;

import com.zj.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {
    @Value("${redis.hostName}")
    private String hostName;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.maxWaitMillis}")
    private Integer maxWaitMillis;

    @Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;

    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Value("${spring.redis.cluster.max-redirects}")
    private Integer mmaxRedirectsac;

    @Value("${redis.sentinel.host1}")
    private String host1;

    @Value("${redis.sentinel.port1}")
    private Integer port1;

    @Value("${redis.sentinel.host3}")
    private String host3;

    @Value("${redis.sentinel.port3}")
    private Integer port3;

    @Value("${redis.sentinel.host2}")
    private String host2;

    @Value("${redis.sentinel.port2}")
    private Integer port2;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 连接池的最大数据库连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        // 最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        // 在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;

    }

    @Bean
    public RedisClusterConfiguration redisClusterConfiguration(){
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        Set<RedisNode> redisNodes = new HashSet<RedisNode>();
        String[] serverArray = clusterNodes.split(",");
        for (String ip_port: serverArray){
            String[] ip_port_array = ip_port.split(":");
            RedisNode redisNode = new RedisNode(ip_port_array[0],Integer.valueOf(ip_port_array[1]));
            redisNodes.add(redisNode);
        }
        redisClusterConfiguration.setClusterNodes(redisNodes);
        redisClusterConfiguration.setMaxRedirects(mmaxRedirectsac);
        return redisClusterConfiguration;
    }
    //单机版
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
//        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
//        rsc.setPort(port);
//        rsc.setHostName(hostName);
//
//        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder  b  = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
//        b.poolConfig(jedisPoolConfig);
//
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(rsc,b.build());
//
//        return jedisConnectionFactory;
//    }
    @Bean
    public RedisSentinelConfiguration sentinelConfiguration(){
        RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration();
        RedisNode redisNode = new RedisNode(hostName,port);
        redisNode.setName("mymaster");
        sentinelConfiguration.master(redisNode);
        Set<RedisNode> sentinelArray = new HashSet<>();
        RedisNode sentinelNode1  = new RedisNode(host1,port1);
        sentinelArray.add(sentinelNode1);
        RedisNode sentinelNode2  = new RedisNode(host2,port2);
        sentinelArray.add(sentinelNode2);
        RedisNode sentinelNode3  = new RedisNode(host3,port3);
        sentinelArray.add(sentinelNode3);
        sentinelConfiguration.setSentinels(sentinelArray);
        return sentinelConfiguration;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisClusterConfiguration redisClusterConfiguration,JedisPoolConfig jedisPoolConfig){

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder  b  = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        b.poolConfig(jedisPoolConfig);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,b.build());

        return jedisConnectionFactory;
    }
    @Bean
    RedisTemplate<String,Object> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new RedisObjectSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean(name = "redisUtil")
    public RedisUtil redisUtil(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate);
        return redisUtil;
    }


}
