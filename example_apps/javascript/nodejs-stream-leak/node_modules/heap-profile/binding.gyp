{
  "targets": [
    {
      "target_name": "sampling_heap_profiler",
      "sources": [ "bindings/sampling-heap-profiler.cc" ],
      "include_dirs": [ "<!(node -e \"require('nan')\")" ],
      "conditions": [
        ['OS=="mac"', {
          'xcode_settings': {
            'CLANG_CXX_LIBRARY': 'libc++',
            'CLANG_CXX_LANGUAGE_STANDARD':'c++11'
          }
        }]
      ]
    }
  ]
}