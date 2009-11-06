package com.sap.mi.gfw.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implements <code>com.tssap.util.trace.TracerI</code> and adds
 * <code>entering</code> to allow trace entries with any kind of parameters when
 * a specific method is entered and <code>exiting</code> to allow trace entries
 * with any kind of parameters when a method is exited. To create an instance,
 * use the static method <code>T.racer()</code> from the concrete sub classes
 * <code>com.sap.mi.gfw.util.T</code> or <code>com.sap.mi.gfw.eclipse.T</code>
 * depending on the package you want to trace.
 * 
 * @see com.tssap.util.trace.TracerI
 */
public abstract class AbstractTracer extends Logger {

    private static final String EOL = System.getProperty("line.separator"); //$NON-NLS-1$

    private static final String EMPTY_STRING = ""; //$NON-NLS-1$

    private static final String ENTERING_MSG = "Entering method "; //$NON-NLS-1$

    private static final String SIGNATURE_PATTERN = "$signature$"; //$NON-NLS-1$

    private static final String FULL_ENTERING_MSG = "#" + ENTERING_MSG + SIGNATURE_PATTERN + "#" + EOL; //$NON-NLS-1$ //$NON-NLS-2$

    private static final String EXITING_MSG = "Exiting method "; //$NON-NLS-1$

    private static final String FULL_EXITING_MSG = "#" + EXITING_MSG + SIGNATURE_PATTERN + "#" + EOL; //$NON-NLS-1$ //$NON-NLS-2$

    private static final String THROWING_MSG = "Throwing"; //$NON-NLS-1$

    private static final String CATCHING_MSG = "Caught"; //$NON-NLS-1$

    private Logger t = null;

    public AbstractTracer(String location) {
        super(location, null);
        t = Logger.getLogger(location);
    }

    /**
     * Writes a trace entry that the specified method was entered.
     * 
     * @param clazz
     *            Class of the traced method
     * @param signature
     *            signature of the traced method
     */
    public void entering(Class clazz, String signature) {
        t.logp(Level.INFO, clazz.getName(), signature, FULL_ENTERING_MSG
                .replaceFirst(SIGNATURE_PATTERN, signature));
    }

    /**
     * Writes a trace entry that the specified method was entered.
     * 
     * @param clazz
     *            Class of the traced method
     * @param signature
     *            signature of the traced method
     * @param args
     *            Arguments as object references
     */
    public void entering(Class clazz, String signature, Object... args) {
        t.logp(Level.INFO, clazz.getName(), signature, createTraceMsg(
                ENTERING_MSG + signature, args));
    }

    /**
     * Writes a trace entry that the specified method is about to be exited.
     * 
     * @param clazz
     *            Class of the traced method
     * @param signature
     *            signature of the traced method
     */
    public void exiting(Class clazz, String signature) {
        t.logp(Level.INFO, clazz.getName(), signature, FULL_EXITING_MSG
                .replaceFirst(SIGNATURE_PATTERN, signature));
    }

    /**
     * Writes a trace entry that the specified method is about to be exited.
     * 
     * @param clazz
     *            Class of the traced method
     * @param signature
     *            signature of the traced method
     * @param res
     *            Result as object reference
     */
    public void exiting(Class clazz, String signature, Object res) {
        Object result = res;
        if (result == null) {
            result = new String("<null>"); //$NON-NLS-1$
        }
        t.logp(Level.INFO, clazz.getName(), signature, createTraceMsg(
                EXITING_MSG + signature, new Object[] { result }));
    }

    /**
     * Writes a trace entry that the specified throwable is about to be thrown.
     * 
     * @param clazz
     *            Class of the traced method
     * @param signature
     *            signature of the traced method
     * @param throwable
     *            Throwable
     */
    public void throwing(Class clazz, String signature, Throwable throwable) {
        t.logp(Level.WARNING, clazz.getName(), signature, THROWING_MSG,
                throwable);
    }

    /**
     * Writes a trace entry that the specified throwable was caught.
     * 
     * @param clazz
     *            Class of the traced method
     * @param signature
     *            signature of the traced method
     * @param throwable
     *            Throwable
     */
    public void catching(Class clazz, String signature, Throwable throwable) {
        t.logp(Level.WARNING, clazz.getName(), signature, CATCHING_MSG,
                throwable);
    }

    public boolean debug() {
        return t.isLoggable(Level.FINE);
    }

    public void debug(Class clazz, String methodName, String msg) {
        t.logp(Level.FINE, clazz.getName(), methodName, msg);
    }

    public void debug(String className, String methodName, String msg) {
        t.logp(Level.FINE, className, methodName, msg);
    }

    public void debug(String methodName, String msg) {
        t.logp(Level.FINE, getName(), methodName, msg);
    }

    public void debug(String msg) {
        t.fine(msg);
    }

    public boolean error() {
        return t.isLoggable(Level.SEVERE);
    }

    public void error(Class clazz, String methodName, String msg,
            Throwable throwable) {
        t.logp(Level.SEVERE, clazz.getName(), methodName, msg, throwable);
    }

    public void error(Class clazz, String methodName, String msg) {
        t.logp(Level.SEVERE, clazz.getName(), methodName, msg);
    }

    public void error(String className, String methodName, String msg,
            Throwable throwable) {
        t.logp(Level.SEVERE, className, methodName, msg, throwable);
    }

    public void error(String className, String methodName, String msg) {
        t.logp(Level.SEVERE, className, methodName, msg);
    }

    public void error(String methodName, String msg, Throwable throwable) {
        t.logp(Level.SEVERE, getName(), methodName, msg, throwable);
    }

    public void error(String methodName, String msg) {
        t.logp(Level.SEVERE, getName(), methodName, msg);
    }

    public void error(String msg, Throwable throwable) {
        t.log(Level.SEVERE, msg, throwable);
    }

    public void error(String msg) {
        t.severe(msg);
    }

    public boolean fatal() {
        return t.isLoggable(Level.SEVERE);
    }

    public void fatal(Class clazz, String methodName, String msg,
            Throwable throwable) {
        t.logp(Level.SEVERE, clazz.getName(), methodName, msg, throwable);
    }

    public void fatal(Class clazz, String methodName, String msg) {
        t.logp(Level.SEVERE, clazz.getName(), methodName, msg);
    }

    public void fatal(String className, String methodName, String msg,
            Throwable throwable) {
        t.logp(Level.SEVERE, className, methodName, msg, throwable);
    }

    public void fatal(String className, String methodName, String msg) {
        t.logp(Level.SEVERE, className, methodName, msg);
    }

    public void fatal(String methodName, String msg, Throwable throwable) {
        t.logp(Level.SEVERE, getName(), methodName, msg, throwable);
    }

    public void fatal(String methodName, String msg) {
        t.logp(Level.SEVERE, getName(), methodName, msg);
    }

    public void fatal(String msg, Throwable throwable) {
        t.log(Level.SEVERE, msg, throwable);
    }

    public void fatal(String msg) {
        t.severe(msg);
    }

    public Level getTraceLevel() {
        return t.getLevel();
    }

    public boolean info() {
        return t.isLoggable(Level.INFO);
    }

    public void info(Class clazz, String methodName, String msg) {
        t.logp(Level.INFO, clazz.getName(), methodName, msg);
    }

    public void info(String className, String methodName, String msg) {
        t.logp(Level.INFO, className, methodName, msg);
    }

    public void info(String methodName, String msg) {
        t.logp(Level.INFO, getName(), methodName, msg);
    }

    @Override
    public void info(String msg) {
        t.info(msg);
    }

    // public void log(int level, Class clazz, String methodName, String msg,
    // Throwable throwable) {
    // t.log(level, clazz, methodName, msg, throwable);
    // }
    //
    // public void log(int level, Class clazz, String methodName, String msg) {
    // t.log(level, clazz, methodName, msg);
    // }
    //
    // public void log(int level, String className, String methodName, String
    // msg,
    // Throwable throwable) {
    // t.log(level, className, methodName, msg, throwable);
    // }
    //
    // public void log(int level, String className, String methodName, String
    // msg) {
    // t.log(level, className, methodName, msg);
    // }
    //
    // public void log(int level, String methodName, String msg) {
    // t.log(level, methodName, msg);
    // }
    //
    // public void log(int level, String msg, Throwable throwable) {
    // t.log(level, msg, throwable);
    // }
    //
    // public void log(int level, String msg) {
    // t.log(level, msg);
    // }
    //
    // public boolean log(int level) {
    // return t.log(level);
    // }
    //
    // public boolean path() {
    // return t.path();
    // }
    //
    // public void path(Class clazz, String methodName, String msg) {
    // t.path(clazz, methodName, msg);
    // }
    //
    // public void path(String className, String methodName, String msg) {
    // t.path(className, methodName, msg);
    // }
    //
    // public void path(String methodName, String msg) {
    // t.path(methodName, msg);
    // }
    //
    // public void path(String msg) {
    // t.path(msg);
    // }
    //
    // public void userOut(int level, String msg) {
    // t.userOut(level, msg);
    // }
    //
    // public void userOut(String subCategory, int level, String msg) {
    // t.userOut(subCategory, level, msg);
    // }
    //
    // public void userOut(String subCategory, String msg) {
    // t.userOut(subCategory, msg);
    // }
    //
    // public void userOut(String msg) {
    // t.userOut(msg);
    // }
    //
    // public boolean warning() {
    // return t.warning();
    // }

    public void warning(Class clazz, String methodName, String msg,
            Throwable throwable) {
        t.logp(Level.WARNING, clazz.getName(), methodName, msg, throwable);
    }

    public void warning(Class clazz, String methodName, String msg) {
        t.logp(Level.WARNING, clazz.getName(), methodName, msg);
    }

    public void warning(String className, String methodName, String msg,
            Throwable throwable) {
        t.logp(Level.WARNING, className, methodName, msg, throwable);
    }

    public void warning(String className, String methodName, String msg) {
        t.logp(Level.WARNING, className, methodName, msg);
    }

    public void warning(String methodName, String msg, Throwable throwable) {
        t.logp(Level.WARNING, getName(), methodName, msg, throwable);
    }

    public void warning(String methodName, String msg) {
        t.logp(Level.WARNING, getName(), methodName, msg);
    }

    public void warning(String msg, Throwable throwable) {
        t.log(Level.WARNING, msg, throwable);
    }

    @Override
    public void warning(String msg) {
        t.warning(msg);
    }

    @SuppressWarnings("deprecation")
    public boolean fine() {
        return false;
    }

    @SuppressWarnings("deprecation")
    public void fine(Class clazz, String methodName, String msg) {
    }

    @SuppressWarnings("deprecation")
    public void fine(String className, String methodName, String msg) {
    }

    @SuppressWarnings("deprecation")
    public void fine(String methodName, String msg) {
    }

    @Override
    @SuppressWarnings("deprecation")
    public void fine(String msg) {
    }

    @SuppressWarnings("deprecation")
    public boolean finer() {
        return false;
    }

    @SuppressWarnings("deprecation")
    public void finer(Class clazz, String methodName, String msg) {
    }

    @SuppressWarnings("deprecation")
    public void finer(String className, String methodName, String msg) {
    }

    @SuppressWarnings("deprecation")
    public void finer(String methodName, String msg) {
    }

    @Override
    @SuppressWarnings("deprecation")
    public void finer(String msg) {
    }

    @SuppressWarnings("deprecation")
    public boolean finest() {
        return false;
    }

    @SuppressWarnings("deprecation")
    public void finest(Class clazz, String methodName, String msg) {
    }

    @SuppressWarnings("deprecation")
    public void finest(String className, String methodName, String msg) {
    }

    @SuppressWarnings("deprecation")
    public void finest(String methodName, String msg) {
    }

    @Override
    @SuppressWarnings("deprecation")
    public void finest(String msg) {
    }

    private String createTraceMsg(String msg, Object... args) {
        StringBuffer sb = new StringBuffer(512);
        StringBuffer esc = new StringBuffer();

        sb.append('#');
        sb.append(msg);

        if (args != null) {
            sb.append('#');
            sb.append(args.length);
            for (int i = 0; i < args.length; i++) {
                sb.append('#');
                if (args[i] != null) {
                    sb.append(escape(args[i].toString(), esc));
                } else {
                    sb.append(EMPTY_STRING);
                }
            }
        }

        sb.append('#');
        sb.append(EOL);
        return sb.toString();
    }

    private StringBuffer escape(String s, StringBuffer buf) {
        int len = 0;

        if (s == null) {
            s = EMPTY_STRING;
        }

        len = s.length();

        buf.setLength(0);
        buf.append(s);
        for (int i = 0; i < len; ++i) {
            switch (buf.charAt(i)) {
            case '#': {
                buf.replace(i, i + 1, "\\#"); //$NON-NLS-1$
                ++len;
                ++i;
                break;
            }
            case '\\': {
                buf.replace(i, i + 1, "\\\\"); //$NON-NLS-1$
                ++len;
                ++i;
                break;
            }
            }
        }
        return buf;
    }

}