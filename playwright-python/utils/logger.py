import logging
import os

def setup_logger():
    logger = logging.getLogger("AutomationFramework")
    logger.setLevel(logging.INFO)
    handler = logging.FileHandler("reports/automation.log")
    formatter = logging.Formatter("%(asctime)s - %(name)s - %(levelname)s - %(message)s")
    handler.setFormatter(formatter)
    if not logger.handlers:  # Avoid duplicate handlers
        logger.addHandler(handler)
    return logger