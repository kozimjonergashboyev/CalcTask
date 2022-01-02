#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_uz_kozimjon_calctask_MainActivity_stringFromJNI(JNIEnv* env, jobject /* this */, jstring result) {

    return result;
}