package nl.knaw.dans.easy.domain.deposit.discipline;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.knaw.dans.common.jibx.JiBXObjectFactory;
import nl.knaw.dans.common.lang.CacheException;
import nl.knaw.dans.common.lang.ResourceNotFoundException;
import nl.knaw.dans.common.lang.xml.XMLDeserializationException;

public class RecursiveListCache extends AbstractListCache<JiBXRecursiveList>
{
    
    public static final String BASE_FOLDER = "easy-business/discipline/emd/recursivelist/";

    public static final String LID_EASY_COLLECTIONS = "easy-collections/collections";

    public static final String LID_ARCHAEOLOGY_DC_SUBJECT = "archaeology.dc.subject";

    public static final String LID_ARCHAEOLOGY_DCTERMS_TEMPORAL = "archaeology.dcterms.temporal";
    
    private static final Logger logger = LoggerFactory.getLogger(RecursiveListCache.class);
    
    private static RecursiveListCache INSTANCE = new RecursiveListCache();
    
    private RecursiveListCache()
    {
        super();
    }
    
    public static RecursiveListCache getInstance()
    {
        return INSTANCE;
    }

    @Override
    protected String getBaseFolder()
    {
        return BASE_FOLDER;
    }

    protected JiBXRecursiveList getObjectForCache(String key, Locale locale) throws CacheException, IOException
    {
        JiBXRecursiveList list = null;
        InputStream inStream = null;
        try
        {
            inStream = getInputStream(key, locale);
            list = (JiBXRecursiveList) JiBXObjectFactory.unmarshal(JiBXRecursiveList.class, inStream);
        }
        catch (IOException e)
        {
            String msg = "Unable to get 'RecursiveList:" + key + "': ";
            logger.error(msg, e);
            throw new CacheException(msg, e);
        }
        catch (ResourceNotFoundException e)
        {
            String msg = "Resource for 'RecursiveList:" + key + "' not found: ";
            logger.error(msg, e);
            throw new CacheException(msg, e);
        }
        catch (XMLDeserializationException e)
        {
            String msg = "Unable to unmarshal 'RecursiveList:" + key + "': ";
            logger.error(msg, e);
            throw new CacheException(msg, e);
        }
        finally
        {
            if (inStream != null)
            {
                inStream.close();
            }
        }
        return list;
    }

}
