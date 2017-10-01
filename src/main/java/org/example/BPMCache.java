package org.example;

import com.ibm.websphere.cache.DistributedMap;
import com.ibm.websphere.cache.EntryInfo;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Класс для работы с Distributed Map в IBM BPM
 */
public final class BPMCache {
    private static String JNDI_NAME = "";
    private static int DEFAULT_SHARING_POLICY = EntryInfo.SHARED_PUSH;
    private DistributedMap distributedMap;

    private static final Logger LOGGER = Logger.getLogger(BPMCache.class.getName());

    public BPMCache() {
        distributedMap = null;
    }

    private void initialiseCacheMap(String jndi) throws BPMCacheException {
        LOGGER.info("Calling: BPMCache.initialiseCacheMap");

        if (!JNDI_NAME.equals(jndi)) {
            JNDI_NAME = jndi;
            distributedMap = null;
        }

        if (distributedMap == null) {
            try {
                InitialContext initialContext = new InitialContext();
                distributedMap = (DistributedMap) initialContext.lookup(JNDI_NAME);
            } catch (NamingException var3) {
                throw new BPMCacheException("Failed to retreive the Object Cache Instance with JNDI: " + JNDI_NAME);
            }
        }

        LOGGER.info("Complete: BPMCache.initialiseCacheMap");
    }

    /**
     * Добавить объект в Distributed Map (cache)
     *
     * @param jndi           JNDI экземпляра объекта для кэширования
     * @param key            Ключ для доступа к объекту
     * @param value          Объект-значение, ассоциированное с ключом
     * @param priority       Приоритет объекта-значения (от 1 до 16, 1 - значение по умолчанию). Объекты с большим преоритетом находятся в кэше дольше чем объекты с меньшим преоритетом в случае переполнения кэша.
     * @param timeToLive     Время жизни объекта-значения (в секундах) (-1 - время жизни не ограничено, значение по умолчанию)
     * @param inactivityTime Число секунд, после которых объект обхявляется недействительным. Сбрасывается при каждом обращении.
     * @throws BPMCacheException
     */
    public void put(String jndi, String key, Object value, int priority, int timeToLive, int inactivityTime) throws BPMCacheException {
        LOGGER.info("Calling: BPMCache.put");
        initialiseCacheMap(jndi);
        distributedMap.put(key, value, priority, timeToLive, inactivityTime, DEFAULT_SHARING_POLICY, null);
    }

    /**
     * Получить объект из Distributed Map (cache)
     *
     * @param jndi JNDI экземпляра объекта для кэширования
     * @param key  Ключ для доступа к объекту
     * @return Объект-значение, ассоциированное с ключом или null при отсутствии
     * @throws BPMCacheException
     */
    public Object get(String jndi, String key) throws BPMCacheException {
        initialiseCacheMap(jndi);
        return distributedMap.get(key);
    }

    /**
     * Проверить наличие ключа в Distributed Map
     *
     * @param jndi JNDI экземпляра объекта для кэширования
     * @param key  Ключ для доступа к объекту
     * @return true если ключ найден, false если ключ не найден
     * @throws BPMCacheException
     */
    public boolean containsKey(String jndi, String key) throws BPMCacheException {
        initialiseCacheMap(jndi);
        return distributedMap.containsKey(key);
    }

    /**
     * Вручную инвалидировать значение по ключу.
     *
     * @param jndi JNDI экземпляра объекта для кэширования
     * @param key  Ключ для доступа к объекту
     * @throws BPMCacheException
     */
    public void invalidate(String jndi, String key) throws BPMCacheException {
        initialiseCacheMap(jndi);
        distributedMap.invalidate(key);
    }

    /**
     * Очистить экземпляр объекта для кэширования и удалить все оъекты в нем.
     *
     * @param jndi JNDI экземпляра объекта для кэширования
     * @throws BPMCacheException
     */
    public void clearCache(String jndi) throws BPMCacheException {
        initialiseCacheMap(jndi);
        distributedMap.clear();
    }
}
