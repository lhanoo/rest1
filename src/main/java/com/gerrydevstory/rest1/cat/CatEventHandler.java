package com.gerrydevstory.rest1.cat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
@RepositoryEventHandler(Cat.class)
@Secured("ROLE_ADMIN")
public class CatEventHandler {

  private static final Logger LOG = LoggerFactory.getLogger(CatEventHandler.class);
  
  @HandleBeforeSave
  public void handleBeforeSave(Cat c) {
    LOG.debug("Before save " + c);
  }
  
  @HandleBeforeCreate
  public void handleBeforeCreate(Cat c) {
    LOG.debug("Before create " + c);
  }
  
  @HandleBeforeLinkSave
  public void handleBeforeLinkSave(Cat c) {
    LOG.debug("Before link save " + c);
  }
  
  @HandleBeforeDelete
  public void handleBeforeDelete(Cat c) {
    LOG.debug("Before delete " + c);
  }
  
  @HandleBeforeLinkDelete
  public void handleBeforeLinkDelete(Cat c) {
    LOG.debug("Before link delete " + c);
  }
}

