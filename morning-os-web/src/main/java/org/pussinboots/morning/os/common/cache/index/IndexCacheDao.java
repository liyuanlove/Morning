package org.pussinboots.morning.os.common.cache.index;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Create by ZengShiLin on 2018-02-05
 * 首页缓存
 * 由于广告缓存先做的命名上面没有遵循规范后续的会规范
 */
@Component
public class IndexCacheDao {

    private JedisPool jedisPool;
    //protostuff,字节码
    private RuntimeSchema<IndexCacheAdDto> schemaAd = RuntimeSchema.createFrom(IndexCacheAdDto.class);
    private RuntimeSchema<IndexCacheNaDto> schemaNa = RuntimeSchema.createFrom(IndexCacheNaDto.class);
    private RuntimeSchema<IndexCacheCaDto> schemaCa = RuntimeSchema.createFrom(IndexCacheCaDto.class);

    //先写死（后续在Spring.xml里面加入尽可能的减少IO不适用查询配置文件的方式）
    public IndexCacheDao (){
        jedisPool = new JedisPool("119.29.209.127",6320);
    }

    //广告缓存key前缀
    private final static String keypreAd = "IndexcacheAD";
    //导航栏缓存key前缀
    private final static String keypreNa ="IndexcacheNA";
    //商品缓存key前缀
    private final static String keypreCa ="IndexcacheCA";

    /**
     * 广告缓存dao
     * @return
     */
    public IndexCacheAdDto getIndexCacheAd(){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                byte[] bytes = jedis.get((keypreAd).getBytes());
                if(bytes != null){
                    IndexCacheAdDto indexCacheDto = schemaAd.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes,indexCacheDto,schemaAd);
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入广告缓存
     */
    public String putIndexCacheAd(IndexCacheAdDto indexCacheDto){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                byte[] bytes = ProtobufIOUtil.toByteArray(indexCacheDto,schemaAd,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //缓存时间
                int time = 30*60;
                String result = jedis.setex(keypreAd.getBytes(),time,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 导航栏缓存
     * @return
     */
    public IndexCacheNaDto getIndexNache(){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                byte[] bytes = jedis.get((keypreNa).getBytes());
                if(bytes != null){
                    IndexCacheNaDto indexCacheNaDto = schemaNa.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes,indexCacheNaDto,schemaNa);
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入导航栏缓存
     * @param
     * @return
     */
    public String putIndexCacheNa(IndexCacheNaDto indexCacheNaDto){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                byte[] bytes = ProtobufIOUtil.toByteArray(indexCacheNaDto,schemaNa,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //缓存时间
                int time = 30*60;
                String result = jedis.setex(keypreNa.getBytes(),time,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 商品分类缓存
     * @return
     */
    public IndexCacheCaDto getIndexCacheCa(){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                byte[] bytes = jedis.get((keypreCa).getBytes());
                if(bytes != null){
                    IndexCacheCaDto indexCacheCaDto = schemaCa.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes,indexCacheCaDto,schemaCa);
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 商品分类缓存
     * @param
     * @return
     */
    public String putIndexCacheCa(IndexCacheCaDto indexCacheCaDto){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                byte[] bytes = ProtobufIOUtil.toByteArray(indexCacheCaDto,schemaCa,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //缓存时间
                int time = 30*60;
                String result = jedis.setex(keypreCa.getBytes(),time,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
