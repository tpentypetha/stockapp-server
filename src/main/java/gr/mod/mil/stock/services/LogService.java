package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.LogEntry;
import gr.mod.mil.stock.dal.repos.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogService {

    private final static String SYSTEM = "system";
    private final static String UNAUTHORIZED = "unauthorize";

    @Autowired
    LogRepository repository;

    private final static Logger logger = LoggerFactory.getLogger(LogService.class);

    public void systemLog(String what){
        LogEntry entry = createEntry(SYSTEM, what);
        logger.info(entry.toString());
        repository.save(entry);
    }

    public void log(String what) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LogEntry entry = createEntry(auth.getName(), what);
        logger.info(entry.toString());
        repository.save(entry);
    }

    private LogEntry createEntry(String who, String what) {
        LogEntry entry = new LogEntry();
        entry.setWho(who);
        entry.setWhat(what);
        entry.setWhen(new Date());
        return entry;
    }

}
