package com.shepeliev.webrtckmp.custom

import com.shepeliev.webrtckmp.WebRtc
import org.webrtc.HardwareVideoEncoderFactory
import org.webrtc.VideoCodecInfo
import org.webrtc.VideoEncoderFactory

class LowLatencyHardwareVideoEncoderFactory(
    private val parent: HardwareVideoEncoderFactory = HardwareVideoEncoderFactory(WebRtc.rootEglBase.eglBaseContext, false, false)
) : VideoEncoderFactory by parent {
    // Forcefully get rid of v8
    override fun getSupportedCodecs(): Array<VideoCodecInfo> {
        return parent.supportedCodecs.filterNot {
            it?.name?.contains("V8") == false
        }.toTypedArray()
    }
}