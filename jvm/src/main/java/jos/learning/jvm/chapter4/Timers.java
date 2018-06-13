/*
 * Copyright (c) 2008, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the Classpath exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package jos.learning.jvm.chapter4;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.Strings.str;
import static com.sun.btrace.BTraceUtils.Strings.strcat;
import static com.sun.btrace.BTraceUtils.Sys;
import static com.sun.btrace.BTraceUtils.Threads.jstack;
import static com.sun.btrace.BTraceUtils.println;

/**
 * Demonstrates multiple timer probes with different periods to fire.
 */
@BTrace
public class Timers {

    // when starting print the target VM version and start time
    static {
        println("vm version " + Sys.VM.vmVersion());
        println("vm starttime " + Sys.VM.vmStartTime());
    }

    @OnTimer(5000)
    public static void f() {
        println("Heap:");
        println(Sys.Memory.heapUsage());
        println("Non-Heap:");
        println(Sys.Memory.nonHeapUsage());
    }

    @OnMethod(
            clazz="jos.learning.jvm.chapter4.Bar",
            method="sum",
            location=@Location(Kind.RETURN)
    )
    public static void func(@Self Bar instance,int c,@Return int result) {
        println("调用堆栈:");
        jstack();
        println(strcat("方法参数A:", str(c)));
        println(strcat("方法结果:", str(result)));
    }


}
