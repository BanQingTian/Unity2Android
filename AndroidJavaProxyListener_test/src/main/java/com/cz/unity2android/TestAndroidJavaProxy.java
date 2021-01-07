package com.cz.unity2android;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class TestAndroidJavaProxy {


    //region 参数
    // 日志标签
    private final String TAG = "TestAndroidJavaProxy";

    // 接口参数
    private ITest mTstInterface;

    // 定时器
    Timer timer1 = new Timer();
    Timer timer2 = new Timer();
    //endregion


    /**
     * 设置接口函数示例的对外接口
     * 便于测试：定时 1s 和 3s 调用函数
     * @param testInterface 接口实例
     */
    public void SetTestInterface(ITest testInterface){

        mTstInterface = testInterface;

        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                //do something
                TestFunc_1();
            }
        },1000);//延时1s执行

        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                //do something
                TestFunc_2();
            }
        },3000);//延时2s执行
    }

    /**
     * 测试接口函数一
     */
    void TestFunc_1(){

        Log.i(TAG,"TestFunc_1");

        if(mTstInterface != null){

            mTstInterface.func_1();
        }
    }

    /**
     * 测试接口函数二（带参数）
     */
    void TestFunc_2(){

        Log.i(TAG,"TestFunc_2");

        if(mTstInterface != null){

            mTstInterface.func_2("TestFunc_2");
        }
    }

}
